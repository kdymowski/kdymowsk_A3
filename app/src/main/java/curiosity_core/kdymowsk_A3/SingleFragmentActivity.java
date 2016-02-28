package curiosity_core.kdymowsk_A3;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;



import curiosity_core.criminalintent.R;

/**
 * Created by curiosity-core on 2/17/16.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {
    protected abstract android.support.v4.app.Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null)
        {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
