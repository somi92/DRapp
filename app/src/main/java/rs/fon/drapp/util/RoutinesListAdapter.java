package rs.fon.drapp.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import rs.fon.drapp.R;
import rs.fon.drapp.domain.Routine;
import rs.fon.drapp.loaders.AssetsManager;

/**
 * Created by milos on 9/18/15.
 */
public class RoutinesListAdapter extends ArrayAdapter<Routine> {

    private List<Routine> mRoutines;
    private Context mContext;

    public RoutinesListAdapter(Context context, List<Routine> routines) {
        super(context, 0, routines);
        mRoutines = routines;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Routine r = mRoutines.get(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView tvTitle = (TextView) convertView.findViewById(R.id.item_title);
        tvTitle.setText(r.getTitle());
        TextView tvNumSteps = (TextView) convertView.findViewById(R.id.item_num_steps);
        tvNumSteps.setText("Broj koraka: "+r.getSteps().size());
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.list_image);
        ivImage.setImageDrawable(AssetsManager.getInstance().getDrawableAsset(mContext, r.getImageResource()));

        return convertView;
    }
}
