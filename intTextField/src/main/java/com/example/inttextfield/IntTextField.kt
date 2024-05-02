package com.example.inttextfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun IntTextField(
    value: Int,
    maxValue: Int? = null,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Number
    ),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = TextFieldDefaults.shape,
    colors: TextFieldColors = TextFieldDefaults.colors(),
) {
    var text by remember {
        mutableStateOf(value.toString())
    }

    TextField(
        value = text,
        onValueChange = { newText ->
            convertTextToIntFieldValue(newText, maxValue).also {
                text = it.first
                onValueChange(it.second)
            }
        },
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        prefix = prefix,
        suffix = suffix,
        supportingText = supportingText,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )
}

private fun convertTextToIntFieldValue(
    newText: String,
    maxValue: Int?
): Pair<String, Int> {
    if (newText.isEmpty()) {
        return Pair("", 0)
    }
    val filteredDigits = newText.filter { it.isDigit() }
    val validatedInt = parseBoundedIntFromString(filteredDigits)
    val checkInt = checkIntRange(validatedInt, maxValue)
    return Pair(checkInt.toString(), checkInt)
}

private fun parseBoundedIntFromString(value: String): Int {
    val longValue = value.toLong()
    return when {
        longValue > Int.MAX_VALUE -> Int.MAX_VALUE
        longValue < Int.MIN_VALUE -> Int.MIN_VALUE
        else -> longValue.toInt()
    }
}

private fun checkIntRange(
    value: Int,
    maxValue: Int?
): Int {
    return when {
        maxValue != null && value > maxValue -> maxValue
        else -> value
    }
}
