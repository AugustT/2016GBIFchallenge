package speciemongo.net.speciemongo;

import android.app.Application;
import android.os.StrictMode;

import com.instabug.library.IBGInvocationEvent;
import com.instabug.library.Instabug;

/**
 * The {@link Application} implementation for the app.
 */
public class SgApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // If we are in debug mode,
        if(BuildConfig.DEBUG) {

            // Enable strict mode
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());

        }

        // Initialize Instabug
        new Instabug.Builder(this, "09eb9f6a678f5331c074cfe615d6ba3e")
                .setInvocationEvent(IBGInvocationEvent.IBGInvocationEventShake)
                .build();

    }
}
