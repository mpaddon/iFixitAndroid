package com.dozuki.ifixit.guide_view.ui;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.ImageView;

import com.dozuki.ifixit.R;
import com.dozuki.ifixit.guide_view.model.StepLine;
import com.dozuki.ifixit.util.JSONHelper;

import org.holoeverywhere.LayoutInflater;
import org.holoeverywhere.widget.LinearLayout;
import org.holoeverywhere.widget.TextView;

public class GuideStepLineView extends LinearLayout {
   private static final int LINE_INDENT = 50;
   private static final int MARGIN = 10;

   private TextView mStepText;
   private ImageView mBulletView;
   private ImageView mIconView;
   private LinearLayout mRow;

   public GuideStepLineView(Context context) {
      super(context);

      LayoutInflater inflater = (LayoutInflater)context
       .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      inflater.inflate(R.layout.guide_step_row, this, true);

      mRow = (LinearLayout) findViewById(R.id.step_row);
   }

   public void setLine(StepLine line) {
      int iconRes, bulletRes;

      mStepText = (TextView) findViewById(R.id.step_text);
      mStepText.setText(JSONHelper.correctLinkPaths(Html.fromHtml(
       line.getText())));
      mStepText.setMovementMethod(LinkMovementMethod.getInstance());

      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
       LinearLayout.LayoutParams.MATCH_PARENT,
       LinearLayout.LayoutParams.WRAP_CONTENT);

      layoutParams.setMargins(LINE_INDENT * line.getLevel(), MARGIN, 0,
       MARGIN);
      mRow.setLayoutParams(layoutParams);

      mBulletView = (ImageView)findViewById(R.id.bullet);
      bulletRes = getBulletResource(line.getColor());
      mBulletView.setImageResource(bulletRes);
      mBulletView.setLayoutParams(new LinearLayout.LayoutParams(
       LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));

      mIconView = (ImageView) findViewById(R.id.bullet_icon);

      if (line.hasIcon()) {
         if (line.getColor().equals("icon_reminder")) {
            iconRes = R.drawable.icon_reminder;
         } else if (line.getColor().equals("icon_caution")) {
            iconRes = R.drawable.icon_caution;
         } else if (line.getColor().equals("icon_note")) {
            iconRes = R.drawable.icon_note;
         } else {
            Log.e("setLine", "Step icon resource not there");
            iconRes = 0;
         }

         mIconView.setImageResource(iconRes);
         mIconView.setVisibility(VISIBLE);
         mIconView.setLayoutParams(new LinearLayout.LayoutParams(
          LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
      } else {
         mIconView.setVisibility(INVISIBLE);
      }
   }

   public int getBulletResource(String color) {
      int iconRes;

      if (color.equals("black")) {
         iconRes = R.drawable.bullet_black;
      } else if (color.equals("orange")) {
         iconRes = R.drawable.bullet_orange;
      } else if (color.equals("blue")) {
         iconRes = R.drawable.bullet_blue;
      } else if (color.equals("purple")) {
         iconRes = R.drawable.bullet_purple;
      } else if (color.equals("red")) {
         iconRes = R.drawable.bullet_red;
      } else if (color.equals("teal")) {
         iconRes = R.drawable.bullet_teal;
      } else if (color.equals("white")) {
         iconRes = R.drawable.bullet_white;
      } else if (color.equals("yellow")) {
         iconRes = R.drawable.bullet_yellow;
      } else {
         iconRes = R.drawable.bullet_black;
      }

      return iconRes;
   }
}
