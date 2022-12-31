package com.example.notekeeper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notekeeper.databinding.ActivityNoteListBinding;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    private NoteRecyclerAdapter mNoteRecyclerAdapter;
    //    private ArrayAdapter<NoteInfo> mNotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.notekeeper.databinding.ActivityNoteListBinding binding = ActivityNoteListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(view ->
                startActivity(new Intent(NoteListActivity.this, NoteActivity.class)));
        
        initializeDisplayContent();
        
    }

    // this should fix the crash happens when we go back.
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();
//        mNotesAdapter.notifyDataSetChanged();
        mNoteRecyclerAdapter.notifyDataSetChanged();
    }

    private void initializeDisplayContent() {
        /*        // now list has the data from that code adapter
        final ListView listNotes = findViewById(R.id.list_notes);
        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        mNotesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listNotes.setAdapter(mNotesAdapter);

        // lets make the user make a selection using the intent which create a new activity

        listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NoteListActivity.this, NoteActivity.class);

                NoteInfo note = (NoteInfo) listNotes.getItemAtPosition(position);
                intent.putExtra(NoteActivity.NOTE_POSITION, position);
                startActivity(intent);
            }
        });
*/
//        final RecyclerView recyclerNotes = findViewById(R.id.list_items);
//        final LinearLayoutManager notesLayoutManager = new LinearLayoutManager(this);
//        recyclerNotes.setLayoutManager(notesLayoutManager);
//
//        List<NoteInfo> notes = DataManager.getInstance().getNotes();
//        mNoteRecyclerAdapter = new NoteRecyclerAdapter(this, notes);
//        recyclerNotes.setAdapter(mNoteRecyclerAdapter);
    }
}
