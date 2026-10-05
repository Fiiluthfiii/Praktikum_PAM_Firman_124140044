package com.example.mobileappminggu4

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobileappminggu4.ui.ProfileScreen
import com.example.mobileappminggu4.viewmodel.ProfileViewModel

@Composable
@Preview
fun App() {
    val profileViewModel: ProfileViewModel = viewModel()
    val uiState by profileViewModel.uiState.collectAsState()
    val colorScheme = if (uiState.isDarkMode) darkColorScheme() else lightColorScheme()

    MaterialTheme(colorScheme = colorScheme) {
        Surface(modifier = Modifier.fillMaxSize()) {
            ProfileScreen(
                uiState = uiState,
                onDarkModeChanged = profileViewModel::setDarkMode,
                onEdit = profileViewModel::startEditing,
                onCancel = profileViewModel::cancelEditing,
                onNameChanged = profileViewModel::updateDraftName,
                onBioChanged = profileViewModel::updateDraftBio,
                onSave = profileViewModel::saveProfile,
            )
        }
    }
}