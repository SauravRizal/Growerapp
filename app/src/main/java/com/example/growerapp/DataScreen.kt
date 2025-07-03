package com.example.growerapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataScreen() {
    var villageCode by remember { mutableStateOf("") }
    var growerCode by remember { mutableStateOf("") }
    var growerData by remember { mutableStateOf<GrowerData?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = villageCode,
            onValueChange = { villageCode = it },
            label = { Text("Village Code") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = growerCode,
            onValueChange = { growerCode = it },
            label = { Text("Grower Code") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // For now, we'll use hardcoded data
                if (villageCode.isNotEmpty() && growerCode.isNotEmpty()) {
                    growerData = GrowerData(
                        growerName = "Saurav Kumar",
                        fatherName = "Raj Kumar",
                        caneArea = "10 Hectares",
                        phoneNumber = "1234567890",
                        bankAccount = "123456789012",
                        aadhar = "1234 5678 9012"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Get Data")
        }

        growerData?.let {
            Spacer(modifier = Modifier.height(32.dp))
            Text("Grower Name: ${it.growerName}")
            Text("Father Name: ${it.fatherName}")
            Text("Cane Area: ${it.caneArea}")
            Text("Phone Number: ${it.phoneNumber}")
            Text("Bank Account: ${it.bankAccount}")
            Text("Aadhar: ${it.aadhar}")
        }
    }
}

data class GrowerData(
    val growerName: String,
    val fatherName: String,
    val caneArea: String,
    val phoneNumber: String,
    val bankAccount: String,
    val aadhar: String
)