package com.inspiron.tharun26.navdrawer;

/**
 * Created by tharun26 on 25/1/15.
 */
import android.content.Context;
import android.content.Intent;

public final class CommonUtilities {

    // give your server registration url here
    static final String SERVER_URL = "http://tharun26.host22.com/register.php";

    // Google project id
    static final String SENDER_ID = "1078980372605";

    /**
     * Tag used on log messages.
     */
    static final String TAG = "GCM";

    static final String DISPLAY_MESSAGE_ACTION =
            "com.inspiron.tharun26.manusys.DISPLAY_MESSAGE";

    static final String EXTRA_MESSAGE = "message";

    /**
     * Notifies UI to display a message.
     * <p>
     * This method is defined in the common helper because it's used both by
     * the UI and the background service.
     *
     * @param context application's context.
     * @param message message to be displayed.
     */
    static void displayMessage(Context context, String message) {
        Intent intent = new Intent(DISPLAY_MESSAGE_ACTION);
        intent.putExtra(EXTRA_MESSAGE, message);
        context.sendBroadcast(intent);
    }
}
