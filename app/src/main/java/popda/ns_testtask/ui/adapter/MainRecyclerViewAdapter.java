package popda.ns_testtask.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.joda.time.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import popda.ns_testtask.R;
import popda.ns_testtask.core.model.NoteModel;


public class MainRecyclerViewAdapter extends RealmRecyclerViewAdapter<NoteModel, MainRecyclerViewAdapter.ViewHolder> {

    public MainRecyclerViewAdapter(OrderedRealmCollection<NoteModel> data) {
        super(data, true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_adapter_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoteModel noteModel = getItem(position);
        if (noteModel == null)
            return;

        DateTime dateTime = new DateTime(noteModel.getTime());

        holder.timeTextview.setText(dateTime.toLocalTime().toString());
        holder.dateTextview.setText(dateTime.toLocalDate().toString());
        holder.textTextview.setText(noteModel.getText());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.time_textview)
        AppCompatTextView timeTextview;
        @BindView(R.id.date_textview)
        AppCompatTextView dateTextview;
        @BindView(R.id.text_textview)
        AppCompatTextView textTextview;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
