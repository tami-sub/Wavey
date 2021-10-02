package com.example.wavey.song


import com.google.gson.annotations.SerializedName

data class SongX(
    @SerializedName("album")
    val album: Album,
    @SerializedName("annotation_count")
    val annotationCount: Int,
    @SerializedName("api_path")
    val apiPath: String,
    @SerializedName("apple_music_id")
    val appleMusicId: String,
    @SerializedName("apple_music_player_url")
    val appleMusicPlayerUrl: String,
    @SerializedName("current_user_metadata")
    val currentUserMetadata: CurrentUserMetadata,
    @SerializedName("custom_performances")
    val customPerformances: List<CustomPerformance>,
    @SerializedName("description")
    val description: Description,
    @SerializedName("description_annotation")
    val descriptionAnnotation: DescriptionAnnotation,
    @SerializedName("embed_content")
    val embedContent: String,
    @SerializedName("fact_track")
    val factTrack: FactTrack,
    @SerializedName("featured_artists")
    val featuredArtists: List<Any>,
    @SerializedName("featured_video")
    val featuredVideo: Boolean,
    @SerializedName("full_title")
    val fullTitle: String,
    @SerializedName("header_image_thumbnail_url")
    val headerImageThumbnailUrl: String,
    @SerializedName("header_image_url")
    val headerImageUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lyrics_marked_complete_by")
    val lyricsMarkedCompleteBy: Any,
    @SerializedName("lyrics_owner_id")
    val lyricsOwnerId: Int,
    @SerializedName("lyrics_placeholder_reason")
    val lyricsPlaceholderReason: Any,
    @SerializedName("lyrics_state")
    val lyricsState: String,
    @SerializedName("media")
    val media: List<Media>,
    @SerializedName("path")
    val path: String,
    @SerializedName("primary_artist")
    val primaryArtist: PrimaryArtist,
    @SerializedName("producer_artists")
    val producerArtists: List<ProducerArtist>,
    @SerializedName("pyongs_count")
    val pyongsCount: Int,
    @SerializedName("recording_location")
    val recordingLocation: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("release_date_for_display")
    val releaseDateForDisplay: String,
    @SerializedName("song_art_image_thumbnail_url")
    val songArtImageThumbnailUrl: String,
    @SerializedName("song_art_image_url")
    val songArtImageUrl: String,
    @SerializedName("song_relationships")
    val songRelationships: List<SongRelationship>,
    @SerializedName("stats")
    val stats: StatsX,
    @SerializedName("title")
    val title: String,
    @SerializedName("title_with_featured")
    val titleWithFeatured: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("verified_annotations_by")
    val verifiedAnnotationsBy: List<Any>,
    @SerializedName("verified_contributors")
    val verifiedContributors: List<Any>,
    @SerializedName("verified_lyrics_by")
    val verifiedLyricsBy: List<Any>,
    @SerializedName("writer_artists")
    val writerArtists: List<WriterArtist>
)