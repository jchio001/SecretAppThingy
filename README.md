I don't write README's ever, so this is pretty much plain text.

How the app works:
- Makes an API call for 20 restaurants when the app is initially started
    -- There's no specs on how many restaurants, so I just went with 1 page of 20
- Press on a marker to pop up a window with a small blurb about the restaurant
- Long press if you want to get more details (misclicks are easily captured by normal OnClicks)

- I built this app by doing build => build APK. This app is built using gradle 2.2.3.
- All libraries I've used are open source, and their respective repos can be google'd easily.
- I only built the map portion of the application, as it was the part of the project I had no
  experience with and I didn't really have the full day to do everything. A lot of time was spent
  messing around with MapViews/GoogleMaps and with Google Places API.

Things I'd improve on if I had the full day to write code:
- Implement the ListView (duh)
- Group together XML attributes that frequently appear together on specific types of views into
  a style
- Load more than 1 picture
- More aggressive error checking utilizing Guava