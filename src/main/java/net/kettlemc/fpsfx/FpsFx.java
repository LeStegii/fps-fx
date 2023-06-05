package net.kettlemc.fpsfx;

import javafx.animation.AnimationTimer;

import java.util.Arrays;

/**
 * Calculates the FPS (frames per second) of a JavaFX application.
 */
public class FpsFx {

    public static final int DEFAULT_MEMORY_SIZE = 64;
    private static final double NANO_TO_FPS = 1_000_000_000.0;
    private final double[] latestFrameRates;

    private long lastUpdate = 0;
    private int index = 0;
    private AnimationTimer framerateTimer;

    /**
     * Creates a new instance of FpsFx.
     *
     * @param memorySize the number of frames to remember for the average FPS
     */
    public FpsFx(int memorySize) {
        latestFrameRates = new double[memorySize];
        Arrays.fill(latestFrameRates, -1);
    }

    /**
     * Creates a new instance of FpsFx with a memory size of 64.
     */
    public FpsFx() {
        this(DEFAULT_MEMORY_SIZE);
    }

    static double average(double[] array) {
        double sum = 0;
        int length = array.length;
        for (double fps : array) {
            if (fps == -1) {
                length--;
                continue;
            }
            sum += fps;
        }
        return length == 0 ? 0 : sum / length;
    }

    /**
     * Returns the latest FPS (FPS of the last rendered frame).
     *
     * @return the latest FPS
     */
    public double latestFps() {
        return latestFrameRates[(index == 0 ? 0 : index - 1) % latestFrameRates.length];
    }

    /**
     * Returns the average FPS (average FPS of the last n rendered frames).
     * n is the memorySize passed to the constructor.
     *
     * @return the average FPS
     */
    public double averageFps() {
        return average(latestFrameRates);
    }

    /**
     * Sets up the timer counting the FPS.
     *
     * @return the current instance
     */
    public FpsFx setup() {
        if (this.framerateTimer != null) throw new IllegalStateException("FramerateTimer is already initialized");

        this.framerateTimer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (lastUpdate > 0) {
                    long nanosSinceLastUpdate = now - lastUpdate;
                    double frameRate = NANO_TO_FPS / nanosSinceLastUpdate;
                    index %= latestFrameRates.length;
                    latestFrameRates[index++] = frameRate;
                }
                lastUpdate = now;
            }
        };
        return this;
    }

    /**
     * Starts the timer counting the FPS.
     *
     * @return the current instance
     */
    public FpsFx start() {
        if (this.framerateTimer == null) throw new IllegalStateException("FramerateTimer is not initialized");
        this.framerateTimer.start();
        return this;
    }

    /**
     * Stops the timer counting the FPS.
     */
    public FpsFx stop() {
        if (this.framerateTimer == null) throw new IllegalStateException("FramerateTimer is not initialized");
        this.framerateTimer.stop();
        return this;
    }

}
