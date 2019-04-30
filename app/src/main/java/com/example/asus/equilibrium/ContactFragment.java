package com.example.asus.equilibrium;



import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ContactFragment extends Fragment {

    public ContactFragment() {
    }

    Button Send_feedback;
    EditText name, email, subject, message;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact_us, container, false);


        Send_feedback = (Button) getView().findViewById(R.id.FeedbackButton);
        name = (EditText) getView().findViewById(R.id.Name);
        email = (EditText) getView().findViewById(R.id.Email);
        subject = (EditText) getView().findViewById(R.id.subject);
        message = (EditText) getView().findViewById(R.id.message);

        Send_feedback = (Button)rootView.findViewById(R.id.FeedbackButton);
        Send_feedback.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String b_name = name.getText().toString();
                String b_email = email.getText().toString();
                String b_subject = subject.getText().toString();
                String b_message = message.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_TEXT, b_name);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{b_email});
                email.putExtra(Intent.EXTRA_SUBJECT, b_subject);
                email.putExtra(Intent.EXTRA_TEXT, b_message);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
        return rootView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Typeface opensans = Typeface.createFromAsset(getActivity().getAssets(), "fonts/OpenSans-Light.ttf");


        // TextView contact1 = (TextView) getView().findViewById(R.id.contact1);
        // contact1.setTypeface(opensans);
        //  contact1.setText("Let's Talk !");

        //  TextView contacttext = (TextView) getView().findViewById(R.id.contacttext);
        //   contacttext.setTypeface(opensans);
        //    contacttext.setText("\" If you want to discuss a possible project, know more about me, or just have a chitchat :) please get in touch.\"");

        EditText name = (EditText) getView().findViewById(R.id.Name);
        name.setTypeface(opensans);

        EditText email = (EditText) getView().findViewById(R.id.Email);
        email.setTypeface(opensans);

        EditText message = (EditText) getView().findViewById(R.id.message);
        message.setTypeface(opensans);

        EditText subject = (EditText) getView().findViewById(R.id.subject);
        subject.setTypeface(opensans);

    }

}