package curiosity_core.kdymowsk_A3;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import curiosity_core.kdymowsk_A3.Crime;
import curiosity_core.kdymowsk_A3.CrimeFragment;
import curiosity_core.kdymowsk_A3.CrimeLab;
import curiosity_core.kdymowsk_A3.CrimeListFragment;
import curiosity_core.kdymowsk_A3.CrimePagerActivity;
import curiosity_core.kdymowsk_A3.R;
import curiosity_core.kdymowsk_A3.SingleFragmentActivity;

/**
 * Created by curiosity-core on 2/17/16.
 */
public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.Callbacks, CrimeFragment.Callbacks {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.detail_fragment_container) == null) {
            Intent intent = CrimePagerActivity.newIntent(this, crime.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }

    public void onCrimeUpdated(Crime crime) {
        CrimeListFragment listFragment = (CrimeListFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }

    public void removeFragment(){
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.detail_fragment_container);
        if (fragment != null) {
            manager.beginTransaction().detach(fragment).commit();
        }
        invalidateOptionsMenu();
    }

    public void onCrimeDeleted(Crime crime){

        CrimeLab crimelab =  CrimeLab.get(this);
        crimelab.deleteCrime(crime);
        removeFragment();


    }
    @Override
    public void onResume(){
        super.onResume();
        removeFragment();
    }
}
