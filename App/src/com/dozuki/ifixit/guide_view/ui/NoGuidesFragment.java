package com.dozuki.ifixit.guide_view.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.dozuki.ifixit.R;

import org.holoeverywhere.LayoutInflater;
import org.holoeverywhere.app.Fragment;

public class NoGuidesFragment extends Fragment {
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {
      return inflater.inflate(R.layout.no_guides_fragment, container, false);
   }
}
