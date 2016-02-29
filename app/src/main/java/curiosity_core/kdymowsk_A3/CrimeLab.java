package curiosity_core.kdymowsk_A3;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by curiosity-core on 2/8/16.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;
    private Context mContext;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mContext = context.getApplicationContext();
        mCrimes = new ArrayList<>();

    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public List<Crime> getCrimes(){
        return  mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime crime: mCrimes){
            if (crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }

    public File getPhotoFile(Crime crime) {
        File externalFilesDir = mContext
                .getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            return null;
        }
        return new File(externalFilesDir, crime.getPhotoFilename());
    }
    public void deleteCrime(Crime crime){
        mCrimes.remove(crime);
    }

    public int getCrimeSize() {
        return mCrimes.size();
    }

}
