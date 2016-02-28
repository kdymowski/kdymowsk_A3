package curiosity_core.kdymowsk_A3;

import android.support.v4.app.Fragment;

/**
 * Created by curiosity-core on 2/17/16.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
