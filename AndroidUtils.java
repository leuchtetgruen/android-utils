package de.leuchtetgruen.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class AndroidUtils {
	public static void showInfoAlert(Context ctx, String title, String text) {
		AlertDialog.Builder adb = new AlertDialog.Builder(ctx);
		adb.setTitle(title);
		adb.setMessage(text);
		adb.setPositiveButton("OK", null);
		
		adb.create().show();
	}
	
	public static void hideKeyboard(Context ctx, View v) {
		InputMethodManager imm = (InputMethodManager)ctx.getSystemService(
			      Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

	}
}
