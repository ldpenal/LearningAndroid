    package com.learning.lion.recycler.adapters;

    import android.app.AlertDialog;
    import android.support.v7.widget.RecyclerView;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.learning.lion.recycler.ArticlesManager;
    import com.learning.lion.recycler.R;
    import com.learning.lion.recycler.fragments.WatchArticle;

    import org.w3c.dom.Text;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvTitle;
        private TextView tvText;
        private TextView tvAuthor;
        private Button btnRemove;
        private WatchArticle watchArticle;

        public ViewHolder(View itemView, WatchArticle watchArticle) {
            super(itemView);

            setTvTitle((TextView) itemView. findViewById(R.id.tvTitle));
            setTvText((TextView) itemView.findViewById(R.id.tvText));
            setTvAuthor((TextView) itemView.findViewById(R.id.tvAuthor));
            setBtnRemove((Button) itemView.findViewById(R.id.btnRemove));

            setWatchArticle(watchArticle);

            // getBtnRemove().setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        public TextView getTvTitle() {
            return tvTitle;
        }

        public void setTvTitle(TextView tvTitle) {
            this.tvTitle = tvTitle;
        }

        public TextView getTvText() {
            return tvText;
        }

        public void setTvText(TextView tvText) {
            this.tvText = tvText;
        }

        public TextView getTvAuthor() {
            return tvAuthor;
        }

        public void setTvAuthor(TextView tvAuthor) {
            this.tvAuthor = tvAuthor;
        }

        public Button getBtnRemove() {
            return btnRemove;
        }

        public void setBtnRemove(Button btnRemove) {
            this.btnRemove = btnRemove;
        }

        public WatchArticle getWatchArticle() {
            return watchArticle;
        }

        public void setWatchArticle(WatchArticle watchArticle) {
            this.watchArticle = watchArticle;
        }

        @Override
        public void onClick(View view) {
            getWatchArticle().removeItem(this.getTvTitle().getText().toString());
            /*AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
            alert.setMessage(tvText.getText());
            alert.show();*/

        }
    }