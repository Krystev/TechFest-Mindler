package com.inveitix.mindler.adapters;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.inveitix.mindler.R;
import com.inveitix.mindler.cmn.Question;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by toshiba on 4.6.2016 г..
 */
public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    List<Question> question;
    Context context;

    public QuestionAdapter(Context context, List<Question> question) {
        this.question = question;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.intent_questions, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.position = position;
        holder.txtQuestion.setText(question.get(position).getQuestion());
    }

    @Override
    public int getItemCount() {
        return question.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.txt_question)
        TextView txtQuestion;
        @Bind(R.id.cbox_choosen)
        CheckBox cboxChoosen;
        int position;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                    builder.setView(inflater.inflate(R.layout.check_question, null));
                    builder.show();
                    builder.setTitle(txtQuestion.getText().toString());
                    builder.setCancelable(true);

//                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                    builder.setTitle(txtQuestion.getText().toString());
//                    builder.setMessage(question.get(position).getAnswerA() + "\n" +
//                            question.get(position).getAnswerB() + "\n" +
//                            question.get(position).getAnswerC() + "\n" +
//                            question.get(position).getAnswerD());
//                    builder.setCancelable(true);
//                    builder.show();++
                }
            });
        }
    }
}
