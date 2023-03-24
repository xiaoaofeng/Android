package activity.control.user;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.recitewords.bdc.R;

public class User_ForgetPassword extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.user_forgetpassword);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.title);
    }
}
