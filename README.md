## Record Store Android App

Android app for use with [recordstoreAPI](https://github.com/yanader/recordshopAPI)

### Description

This Android app is a work in progress. 

The app allows user to perform the following functionality on the record store database:

1. Browse all albums
2. Add a new album
3. Update or Delete an existing album (via clickthrough)
4. Filter album list on artist name and/or album name

### Documentation

The codebase is split into a number of individual packages

1. Model
   - Contains album models of different shapes required to properly interact with the API.
2. Service
   - Constructs and provides an instance of the Retrofit dependency used to make HTTP calls.
3. UI.MainActivity
   - Provides business level logic for the main page/album browser.
   - Also includes the AlbumAdapter and RecyclerView used to control album lists.
4. UI.AddAlbum
   - Activity used to contain business logic for adding an album to the database.
5. UI.UpdateAlbum
   - Activity rendered after clickthrough allowing the user to edit album details or delete an album.

Note: Retrofit directly access a localhost version of the API. To run this programme you are required to change the BASE_URL in RetrofitInstance.java

`private static final String BASE_URL = "http://10.0.2.2:8080/api/v1/recordstore/";`

The above can be used if you clone and run a local instance of [recordstoreAPI](https://github.com/yanader/recordshopAPI)

### Functionality TODO

1. Inputs
   - date/number for releaseDate/price
   - spinner/dropdown for genre
2. Auth (in tandem with the API)
3. Styling cleanup

### Bug TODO

1. Clicking on a Album while a filter is active takes the user to an incorrectly populated UpdateAlbumView
