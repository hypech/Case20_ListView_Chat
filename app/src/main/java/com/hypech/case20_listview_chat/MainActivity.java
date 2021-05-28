package com.hypech.case20_listview_chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView msgListView;
    private EditText inputText;

    private ChatsAdapter adapter;
    private final List<ChatData> msgList = new ArrayList<ChatData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText   = findViewById(R.id.input_text);
        Button send = findViewById(R.id.send);
        msgListView = findViewById(R.id.msg_list_view);

        initMsgs();         //feed the data
        adapter = new ChatsAdapter(MainActivity.this, R.layout.chat_items, msgList);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    ChatData msg1 = new ChatData(content, ChatData.TYPE_SENT);
                    ChatData msg2 = new ChatData("I didn’t think so. You don’t like them. You don’t really know why you don’t like them. All you know is you find them repulsive. Consequently, a German soldier conducts a search of a house suspected of hiding Jews. Where does the hawk look? ", ChatData.TYPE_RECEIVED);
                    msgList.add(msg1);
                    msgList.add(msg2);
                    adapter.notifyDataSetChanged();             // refresh ListView when new messages coming
                    msgListView.setSelection(msgList.size());   // go to the end of the ListView
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsgs() {
        ChatData msg1 = new ChatData("If a rat were to walk in here right now as I’m talking, would you treat it to a saucer of your delicious milk?", ChatData.TYPE_RECEIVED);
        msgList.add(msg1);
    }
}