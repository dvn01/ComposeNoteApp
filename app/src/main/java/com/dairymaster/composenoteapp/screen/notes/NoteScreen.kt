package com.dairymaster.composenoteapp.screen.notes

import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dairymaster.composenoteapp.R
import com.dairymaster.composenoteapp.components.NoteButton
import com.dairymaster.composenoteapp.components.NoteInputText
import com.dairymaster.composenoteapp.data.NotesDataSource
import com.dairymaster.composenoteapp.model.Note
import com.dairymaster.composenoteapp.util.formatDate
import java.time.format.DateTimeFormatter

@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }
    var info by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column(modifier = Modifier.padding(8.dp)) {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = "Note Icon"
            )
        },
            backgroundColor = Color(0xFFE3E8EC)
        )

        // CONTENT
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 6.dp
                ),
                text = title, label = "Title", onTextChange = {
                    if (it.all { char -> char.isLetterOrDigit() || char.isWhitespace() }) title = it
                })
            NoteInputText(modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 6.dp
                ), text = info, label = "Add note", onTextChange = {
                if (it.all { char -> char.isLetterOrDigit() || char.isWhitespace() }) info = it
            })

            NoteButton(modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 6.dp
                ), text = "Save", onClick = {
                if (title.isNotEmpty() && info.isNotEmpty()) {
                    // ready to save
                    onAddNote(Note(title = title, info = info))

                    title = ""
                    info = ""

                    Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                }
            })
        }

        Divider(modifier = Modifier.padding(10.dp))

        LazyColumn {
            items(notes) { note ->
                NoteRow(note = note,
                    onNoteClicked = {
                    onRemoveNote(note)
                })
            }
        }

    }
}

@Composable
fun NoteRow(modifier: Modifier = Modifier,
note: Note,
onNoteClicked: (Note) -> Unit){
    Surface(modifier = modifier
        .padding(4.dp)
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
        .fillMaxWidth(),
    color = Color(0xFFDFE6EB),
    elevation = 8.dp) {
        Column(
            modifier
                .clickable {
                    onNoteClicked(note)
                }
                .padding(horizontal = 16.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = note.title, style = MaterialTheme.typography.subtitle2)
            Text(text = note.info, style = MaterialTheme.typography.subtitle1)
            Text(text = formatDate(note.entryDate.time), style = MaterialTheme.typography.caption)
        }
    }
}
