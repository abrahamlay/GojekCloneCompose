package com.abrahamlay.gojekclone.data.mapper

import com.abrahamlay.gojekclone.data.dtos.VideoDto
import com.abrahamlay.gojekclone.domain.entities.VideoModel


/**
 * Created by Abraham Lay on 14/06/20.
 */

class VideoMapper : Mapper<VideoDto?, List<com.abrahamlay.gojekclone.domain.entities.VideoModel>?>() {
    override fun apply(from: VideoDto?): List<com.abrahamlay.gojekclone.domain.entities.VideoModel>? {
        return from?.results?.map { video ->
            com.abrahamlay.gojekclone.domain.entities.VideoModel(
                video.id,
                video.iso31661,
                video.iso6391,
                video.key,
                video.name,
                video.site,
                video.size,
                video.type
            )
        }
    }
}