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
import android.preference.PreferenceManager;

import com.eternizedlab.airqualitydashclock.R;
import com.google.android.apps.dashclock.api.DashClockExtension;
import com.google.android.apps.dashclock.api.ExtensionData;

public class AirQualityExtension extends DashClockExtension {
    private static final String TAG = AirQualityExtension.class.getSimpleName();

    @Override
    protected void onUpdateData(int reason) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        // Publish the extension data update.
        publishUpdate(new ExtensionData().visible(true)
                .icon(R.drawable.ic_launcher).status("Test")
                .expandedTitle("Title").expandedBody("Body")
        );
    }

    @Override
    protected void onInitialize(boolean isReconnect) {
        super.onInitialize(isReconnect);
    }

}