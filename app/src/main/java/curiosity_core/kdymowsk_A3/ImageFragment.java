package curiosity_core.kdymowsk_A3;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import java.io.File;
import java.util.Date;

/**
 * Created by curiosity-core on 2/29/16.
 */
public class ImageFragment extends DialogFragment {
    public static final String EXTRA_IMAGE = ".image";
    private static final String ARG_IMAGE = "image";


    public static ImageFragment newInstance(File image){
        Bundle args = new Bundle();
        args.putSerializable(ARG_IMAGE, image);

        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

   /* @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {




    }
*/
    private void sendResult(int resultCode, Date date) {
        if (getTargetFragment() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_IMAGE, date);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

}
