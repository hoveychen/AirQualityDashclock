//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
package com.eternizedlab.airquality;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.eternizedlab.airqualitydashclock.R;
import com.google.android.apps.dashclock.api.DashClockExtension;
import com.google.android.apps.dashclock.api.ExtensionData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class AirQualityExtension extends DashClockExtension {
    private static final String TAG = AirQualityExtension.class.getSimpleName();

    private QueryResults results;
    private QueryAQI queryAqiTask = null;

    @Override
    protected void onUpdateData(int reason) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        publishResults();
        startNewQuery();
    }

    private void publishResults() {
        if (results == null) {
            return;
        }
        // Publish the extension data update.
        publishUpdate(new ExtensionData().visible(true)
                .icon(R.drawable.ic_launcher).status(results.getOverallAQI().toString())
                .expandedTitle("AQI:" + results.getOverallAQI())
                .expandedBody("AQI in US:" + results.getOverallAQIInUS())
        );
    }

    private void startNewQuery() {
        if (queryAqiTask != null) {
            queryAqiTask.cancel(true);
            queryAqiTask = null;
        }
        queryAqiTask = new QueryAQI();
        queryAqiTask.execute("beijing");
    }

    class QueryAQI extends AsyncTask<String, Void, QueryResults> {
        @Override
        protected QueryResults doInBackground(String... locations) {
            String location = locations[0];
            try {
                URL url = new URL("http://www.pm2d5.com/city/" + location + ".html");
                URLConnection conn = url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                ParserPM2d5 parser = new ParserPM2d5();
                parser.parse(sb.toString());
                return parser.getResults();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(QueryResults queryResults) {
            super.onPostExecute(queryResults);
            if (queryResults == null) {
                return;
            }
            results = queryResults;
            publishResults();
        }

    }

    @Override
    protected void onInitialize(boolean isReconnect) {
        super.onInitialize(isReconnect);
    }


}