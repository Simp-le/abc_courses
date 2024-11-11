package com.abc.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.abc.courses.data.DataSource
import com.abc.courses.model.Topic
import com.abc.courses.data.TopicDataProvider
import com.abc.courses.data.TopicListDataProvider
import com.abc.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { CoursesApp() }
    }
}

@PreviewScreenSizes
@PreviewFontScale
@PreviewLightDark
@PreviewDynamicColors
@Composable
fun CoursesApp() {
    CoursesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Courses(
                topics = DataSource.topics, modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding()
            )
        }
    }
}

@Preview
@Composable
fun Courses(
    @PreviewParameter(TopicListDataProvider::class) topics: List<Topic>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_small)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        items(topics) { topic ->
            TopicCard(topic)
        }
    }
}

@Preview
@Composable
fun TopicCard(
    @PreviewParameter(TopicDataProvider::class) topic: Topic, modifier: Modifier = Modifier
) {
    Card(modifier) {
        Row {
            Image(
                painterResource(topic.imageId),
                contentDescription = null,
                modifier = Modifier
                    .size(68.dp)
                    .aspectRatio(1f)
            )
            Column(Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))) {
                Text(
                    stringResource(topic.nameId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        top = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painterResource(R.drawable.ic_grain), contentDescription = null)
                    Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                    Text(
                        topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}
