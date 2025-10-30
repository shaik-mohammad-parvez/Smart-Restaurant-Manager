package com.restaurantapp.utils

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

@Composable
fun rememberImagePicker(
    onImageSelected: (String) -> Unit
): () -> Unit {
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            imageUri = it
            val imagePath = saveImageToInternalStorage(context, it)
            imagePath?.let { path ->
                onImageSelected(path)
            }
        }
    }

    return {
        launcher.launch("image/*")
    }
}

@Composable
fun rememberCameraCapture(
    onImageCaptured: (String) -> Unit
): () -> Unit {
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success && imageUri != null) {
            val imagePath = imageUri.toString()
            onImageCaptured(imagePath)
        }
    }

    return {
        val photoFile = File.createTempFile(
            "menu_item_",
            ".jpg",
            context.cacheDir
        )
        imageUri = Uri.fromFile(photoFile)
        launcher.launch(imageUri)
    }
}

private fun saveImageToInternalStorage(context: Context, uri: Uri): String? {
    return try {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        val fileName = "menu_item_${System.currentTimeMillis()}.jpg"
        val file = File(context.filesDir, fileName)

        inputStream?.use { input ->
            FileOutputStream(file).use { output ->
                input.copyTo(output)
            }
        }

        file.absolutePath
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
