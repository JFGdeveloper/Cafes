package com.javidev.coffes.ui.screens.checkout

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javidev.coffes.data.Product
import com.javidev.coffes.ui.components.*

@Composable
fun CheckoutScreen(pais: Product, onclick: () -> Unit) {
    val icon = remember { Icons.Default.ArrowBack }
    var city by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    val envio by remember { mutableStateOf(10)}
    var visivility by remember{ mutableStateOf(false)}
    val context = LocalContext.current

    MyScaffold(title = pais.origin, icon = icon, onClick = { onclick() }) {

        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                ProducCard(
                    pais = pais,
                    onClick = {}
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp)

            ) {

                // nombre
                CustomTextField(value = name, placeholder = "Name", onValueChanged = { name = it })

                // email
                CustomTextField(
                    value = email,
                    keyboardType = KeyboardType.Email,
                    placeholder = "Email",
                    onValueChanged = { email = it })

                // telefono
                CustomTextField(
                    value = telefono,
                    keyboardType = KeyboardType.Phone,
                    placeholder = "Phone",
                    onValueChanged = { telefono = it })

                // direccion
                CustomTextField(
                    value = direccion,
                    placeholder = "Address",
                    onValueChanged = { direccion = it })

                // ciudad
                DropdownTextField(
                    value = city,
                    placeHolder = "Ciudad",
                    sugerencias = pais.getListCitys(),
                    onvalueChange = { city = it }
                )

                Row(
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row {
                            Text(text = "Precio:", textAlign = TextAlign.Start)
                            Text(
                                text = "${pais.getPrecio()} ${pais.getMoneda()}",
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(text = "Envio:", textAlign = TextAlign.Start)
                            Text(
                                text = "$envio${pais.getMoneda()}",
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        Row(
                            modifier = Modifier.padding(vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(text = "Total: ${(envio.toDouble()+ pais.getPrecio())} ${pais.getMoneda()}", style = MaterialTheme.typography.h2)
                            CustomButton(
                                label = "Pagar",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 50.dp)
                            ) {
                                visivility = true
                            }
                        }

                        DialogEjem(visivility = visivility){
                              Toast.makeText(context,"SU PEDIDO HA SIDO REALIZADO",Toast.LENGTH_SHORT).show()
                            visivility = false

                        }


                    }// colum
                }
            }
        }// colum
    }// Scaffold
}

@Preview(showBackground = true)
@Composable()
fun PreCheckout() {
    CheckoutScreen(pais = Product.CRI, onclick = {})

}

