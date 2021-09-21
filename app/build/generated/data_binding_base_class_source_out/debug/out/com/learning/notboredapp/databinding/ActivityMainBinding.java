// Generated by view binder compiler. Do not edit!
package com.learning.notboredapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.learning.notboredapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnHome;

  @NonNull
  public final TextInputEditText editParticipants;

  @NonNull
  public final TextInputLayout etParticipants;

  @NonNull
  public final TextView tvTerms;

  @NonNull
  public final TextView tvTitleHome;

  private ActivityMainBinding(@NonNull ScrollView rootView, @NonNull Button btnHome,
      @NonNull TextInputEditText editParticipants, @NonNull TextInputLayout etParticipants,
      @NonNull TextView tvTerms, @NonNull TextView tvTitleHome) {
    this.rootView = rootView;
    this.btnHome = btnHome;
    this.editParticipants = editParticipants;
    this.etParticipants = etParticipants;
    this.tvTerms = tvTerms;
    this.tvTitleHome = tvTitleHome;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnHome;
      Button btnHome = ViewBindings.findChildViewById(rootView, id);
      if (btnHome == null) {
        break missingId;
      }

      id = R.id.editParticipants;
      TextInputEditText editParticipants = ViewBindings.findChildViewById(rootView, id);
      if (editParticipants == null) {
        break missingId;
      }

      id = R.id.etParticipants;
      TextInputLayout etParticipants = ViewBindings.findChildViewById(rootView, id);
      if (etParticipants == null) {
        break missingId;
      }

      id = R.id.tvTerms;
      TextView tvTerms = ViewBindings.findChildViewById(rootView, id);
      if (tvTerms == null) {
        break missingId;
      }

      id = R.id.tvTitleHome;
      TextView tvTitleHome = ViewBindings.findChildViewById(rootView, id);
      if (tvTitleHome == null) {
        break missingId;
      }

      return new ActivityMainBinding((ScrollView) rootView, btnHome, editParticipants,
          etParticipants, tvTerms, tvTitleHome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}