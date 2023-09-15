package com.abyaz.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abyaz.coffeemasters.R
import com.abyaz.coffeemasters.ui.theme.Alternative1
import com.abyaz.coffeemasters.ui.theme.Alternative2


@Composable
fun OffersPage() {
    Column (
        modifier = Modifier.verticalScroll(rememberScrollState()).fillMaxWidth(),
    ){
        Offer(title = "Early Coffee", description = "10% off Offer")
        Offer(title = "Welcome Gift", description = "25% off")
        Offer(title = "Welcome Gift", description = "25% off")
        Offer(title = "Welcome Gift", description = "25% off")
    }
}

@Composable
fun Offer(title: String, description:String) {
    Box (
        modifier = Modifier.padding(20.dp).fillMaxWidth()
    ){
        Image(painter = painterResource(R.drawable.background_pattern),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.matchParentSize()
        )
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            Text(text = title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Alternative1)
                    .padding(16.dp)

            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = description,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .background(Alternative2)
                    .padding(16.dp)
            )
        }
    }
}