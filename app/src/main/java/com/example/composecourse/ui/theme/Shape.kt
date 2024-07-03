package com.example.composecourse.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes

import androidx.compose.ui.unit.dp

// customizing shape
val shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = CutCornerShape(topEnd = 24.dp),
    large = RoundedCornerShape(0.dp)
)