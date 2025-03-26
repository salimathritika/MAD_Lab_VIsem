package com.example.l6q1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the main page content (set initial fragment)
        showHomePageContent();
    }

    // Method to handle the menu button click (which will show the menu)
    public void showMenu(View view) {
        // Create an array of menu options
        String[] menuItems = {"Home Page", "Workout Plans", "Trainers", "Membership", "Contact Us", "About Us"};

        // Create the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an option");
        builder.setItems(menuItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Depending on the item selected, call the corresponding method
                switch (which) {
                    case 0:
                        showHomePageContent();
                        break;
                    case 1:
                        showWorkoutPlans();
                        break;
                    case 2:
                        showTrainers();
                        break;
                    case 3:
                        showMembership();
                        break;
                    case 4:
                        showContactUs();
                        break;
                    case 5:
                        showAboutUs();
                        break;
                }
            }
        });
        builder.show();
    }

    // Methods to show different content (Fragments)

    private void showHomePageContent() {
        replaceFragment(new HomePageFragment());
    }

    private void showWorkoutPlans() {
        replaceFragment(new WorkoutPlansFragment());
    }

    private void showTrainers() {
        replaceFragment(new TrainersFragment());
    }

    private void showMembership() {
        replaceFragment(new MembershipFragment());
    }

    private void showContactUs() {
        replaceFragment(new ContactUsFragment());
    }

    private void showAboutUs() {
        replaceFragment(new AboutUsFragment());
    }

    // Helper method to replace the fragment
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);  // R.id.content_frame is where your fragments are displayed
        transaction.addToBackStack(null);  // This allows users to navigate back to the previous fragment
        transaction.commit();
    }
}
