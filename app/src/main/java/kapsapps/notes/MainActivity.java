package kapsapps.notes;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String AUTHORITY = "com.example.android.datasync.provider";
    // Account type
    public static final String ACCOUNT_TYPE = "com.example.android.basicsyncadapter.account";
    // Account
    public static final String ACCOUNT = "kapil";

    Account mAccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentResolver.setSyncAutomatically(createSyncAccount(getApplicationContext()), AUTHORITY,true);
                //ContentResolver.requestSync(createSyncAccount(getApplicationContext()), AUTHORITY, new Bundle());
            }
        });
    }

    public static Account createSyncAccount(Context context) {
        // Create the account type and default account
        Account newAccount = new Account(
                ACCOUNT, ACCOUNT_TYPE);
        // Get an instance of the Android account manager
        AccountManager accountManager =
                (AccountManager) context.getSystemService(
                        ACCOUNT_SERVICE);

        accountManager.addAccountExplicitly(newAccount,null,null);

        //return accountManager.getAccountsByType(ACCOUNT_TYPE)[0];

        return newAccount;
    }

}
