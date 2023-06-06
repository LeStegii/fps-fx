# ⏰ fps-fx
A simple api for measuring javafx fps.

The idea behind this project is heavily inspired by this [Stackoverflow answer](https://stackoverflow.com/a/28287949). Whilst not the most accurate way of measuring fps, it is a simple way of getting a rough estimate of the fps. It has been used in a similar way in [ReactFx](https://github.com/TomasMikula/ReactFX/blob/master/reactfx/src/main/java/org/reactfx/EventStreams.java#L416).

## 🤷‍♂️ Usage
1. Create a new instance of `FpsFx`. If you want to use an average later, pass in the number of frames you want to average over.
2. Call `setup()` on the instance.
3. Call `start()` on the instance.
4. Call `averageFps()` on the instance to get the average fps or `latestFps()` for the latest fps.
5. Call `stop()` on the instance when you want to stop measuring fps (e.g. when the application is closed).

## 🤔 Should I use this?
Depends on. If you're looking for a simple way of measuring fps, then yes. If you're looking for a more accurate way of measuring fps, then no.

## 🎈 License
- This project is licensed under the [DBAD](https://dbad-license.org/) license.
- [JavaFx](https://github.com/openjdk/jfx) is licensed under the [GNU GPL2](https://github.com/openjdk/jfx/blob/master/LICENSE) license.
- As this project is inspired by this [Stackoverflow answer](https://stackoverflow.com/a/28287949), also checkout [James_D's profile](https://stackoverflow.com/users/2189127/james-d).