package com.example.chatscreen;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatscreen.ChatAdapter;
import com.example.chatscreen.R;

import java.util.ArrayList;
import java.util.List;

// ChatActivity.java
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewChat;
    private EditText editTextMessage;
    private List<Message> messages;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewChat = findViewById(R.id.recyclerViewChat);
        editTextMessage = findViewById(R.id.editTextMessage);

        messages = new ArrayList<>();
        chatAdapter = new ChatAdapter(messages);
        recyclerViewChat.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewChat.setAdapter(chatAdapter);
    }

    public void sendMessage(View view) {
        String messageContent = editTextMessage.getText().toString().trim();
        if (!messageContent.isEmpty()) {
            // For simplicity, assume the sender is the current user
            Message message = new Message();
            messages.add(message);
            chatAdapter.notifyItemInserted(messages.size() - 1);

            // Scroll to the latest message
            recyclerViewChat.smoothScrollToPosition(messages.size() - 1);

            // Clear the input field
            editTextMessage.getText().clear();
        }
    }
}
