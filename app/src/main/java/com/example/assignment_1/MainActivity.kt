package com.example.assignment_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment_1.ui.theme.Assignment_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment_1Theme {
                ProfileScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp

    // Typography scales
    val mainHeading = 20.sp
    val headingSize = 18.sp
    val subHeadingSize = 14.sp

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                    ) {
                        // Back button and title
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.align(Alignment.CenterStart)
                        ) {
                            IconButton(
                                onClick = { /* Handle back */ },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.longtail_rightarrow),
                                    contentDescription = "Back",
                                    tint = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.size(40.dp)
                                        .rotate(180f)
                                )
                            }

                            Text(
                                "Profile",
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }

                        // Support button
                        SupportButton(
                            modifier = Modifier.align(Alignment.CenterEnd),
                            subHeadingSize = subHeadingSize
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = padding.calculateTopPadding())
        ) {
            item {
                // Profile Header
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 40.dp, end = 40.dp)
                ) {
                    // Profile Image
                    Image(
                        painter = painterResource(R.drawable.profile_picture1),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color.Gray, CircleShape)
                    )

                    // Name and Membership Info
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp)
                    ) {
                        Text(
                            "Shekhar",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            "member since Dec, 2020",
                            style = TextStyle(
                                letterSpacing = 2.sp,
                                fontSize = 14.sp
                            ),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    IconButton(
                        onClick = { /* Handle vehicle icon click */ },
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .border(1.dp, MaterialTheme.colorScheme.outline, CircleShape)
                    ) {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = "Vehicle",
                            modifier = Modifier.size(24.dp),
                            tint =  Color(0xE64B4B4B)
                        )
                    }
                }
                VehicleSection()

                // Rest of your content...
                ProfileContent()
            }
        }

    }
}

@Composable
fun SupportButton(modifier: Modifier = Modifier, subHeadingSize: TextUnit) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, Color.DarkGray),
        color = Color.Transparent,
        modifier = modifier.clickable { /* Handle support */ }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 12.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.message_icon),
                contentDescription = "Support",
                tint = Color.DarkGray,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))


            Text(
                "support",
                style = TextStyle(
                    fontSize = 14.sp,
                    letterSpacing = 1.sp
                ),
                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Credit Score Card
        Column(
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp, bottom = 40.dp)
        ) {
            BankItem(R.drawable.meter_icon, "credit score", "757","• REFRESH")
            HorizontalDivider(modifier = Modifier.fillMaxWidth())
            BankItem(R.drawable.meter_icon, "lifetime cashback", "₹3", null)
            HorizontalDivider(modifier = Modifier.fillMaxWidth())
            BankItem(R.drawable.meter_icon, "bank balance", "check", null)
        }

        // Rewards Section
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(40.dp)
        ) {
            Text(
                text = "YOUR REWARDS & BENEFITS",
                style = TextStyle(
                    letterSpacing = 2.sp,
                    fontSize = 16.sp
                ),
                color = Color.LightGray,
            )
            Spacer(modifier = Modifier.height(16.dp))
            RewardItem(title = "cashback balance", value = "₹0")
            HorizontalDivider(modifier = Modifier.fillMaxWidth())
            RewardItem(title = "coins", value = "26,46,583")
            HorizontalDivider(modifier = Modifier.fillMaxWidth())
            RewardItem(title = "win upto Rs 1000", value = "refer and earn ")

            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            // Transactions Section
            Text(
                text = "TRANSACTIONS & SUPPORT",
                style = TextStyle(
                    letterSpacing = 2.sp,
                    fontSize = 16.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(16.dp))
            TransactionItem("all transaction")

        }
    }
}

@Composable
fun RewardItem(title: String, value: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = TextStyle(
                        letterSpacing = 1.sp,
                        fontSize = 14.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = value,
                    style = TextStyle(
                        letterSpacing = 2.sp,
                        fontSize = 10.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Icon(
                painter = painterResource(R.drawable.right_arrow),
                contentDescription = "icon right",
                tint = Color.LightGray
            )
        }
    }
}


@Composable
fun TransactionItem(title: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = TextStyle(
                        letterSpacing = 2.sp,
                        fontSize = 14.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}


@Composable
fun BankItem(title1: Int, title: String, value: String, offer: String?) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(title1),
                contentDescription = "icon",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(20.dp),
                tint = Color.DarkGray
            )
            Text(
                text = title ,
                style = TextStyle(
                    letterSpacing = 1.sp,
                    fontSize = 14.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = offer ?: "",
                style = TextStyle(
                    letterSpacing = 2.sp,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                color = Color(0xFF3DE589),
                modifier = Modifier
                    .padding(start= 5.dp)
            )

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = value,
                style = TextStyle(
                    letterSpacing = 2.sp,
                    fontSize = 10.sp
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                painter = painterResource(R.drawable.longtail_rightarrow),
                contentDescription = "arrow",
                modifier = Modifier
                    .padding(start = 8.dp),
                tint = Color.LightGray
            )

        }
    }
}

@Composable
fun VehicleSection() {
    Surface(
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle garage click */ }
            .padding(40.dp),
        border = BorderStroke(1.dp, Color(0xE64B4B4B))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            IconButton(
                onClick = { /* Handle vehicle icon click */ },
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .border(1.dp, MaterialTheme.colorScheme.outline, CircleShape)
            ) {
                Icon(
                    painter = painterResource(R.drawable.car_icon),
                    contentDescription = "Vehicle",
                    modifier = Modifier.size(18.dp),
                    tint = Color.LightGray
                )
            }

            Column(
                modifier = Modifier
            ) {

                Text(
                    text = "get to know your vehicles, inside out",
                    style = TextStyle(
                        letterSpacing = 2.sp,
                        fontSize = 10.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                    )

                Row(
                    modifier = Modifier
                        .padding(top = 5.dp)
                ){
                    Text(
                        text = "CRED garage",
                        style = TextStyle(
                            letterSpacing = 2.sp,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.size(18.dp)
                    )
                }

            }
        }
    }
}