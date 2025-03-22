package game;

import java.util.function.BiFunction;

public class Effect {

    /**
     * This enum represents all the possible game effects that can be applied to a player or an enemy.
     */
    public enum Effects {
        // POISONED,
        BURNING,
        // FROZEN,
        STUNNED,
        REGEN,
        // INVISIBLE,
        // SLOWED,
        // HASTED,
        // WEAKENED,
        // STRENGTHENED,
    }


    public final Effects type; // The type of effect
    public final int duration; // The duration of the effect in turns
    public final int potency; // The potency of the effect (e.g., damage per turn, healing per turn)
    private int tick; // The current tick of the effect (0 to duration-1)
    private final BiFunction<Integer, Effect, Integer> onTurn; // the effect behavior to apply each turn
    private final int uniqueId; // Unique identifier for the effect instance

    public Effect(Effects type, int duration, int potency, BiFunction<Integer, Effect, Integer> onTurn) {
        this.type = type;
        this.duration = duration;
        this.potency = potency;
        this.tick = 0; // Initialize tick to 0
        this.onTurn = onTurn; // Set the onTurn predicate
        this.uniqueId = generateID(); // Generate a unique ID for this effect instance
    }

    public boolean equals(Effect e){ return this.uniqueId() == e.uniqueId(); }
    public boolean active() { return tick < duration; }

    /**
     * Increments the tick count for the effect. If the tick count reaches the duration, the effect is no longer active.
     */
    public void tick() { tick++; } // Increment the tick count
    public int getRemainingDuration() { return duration - tick; }
    public int getPotency() { return potency; } // Get the potency of the effect

    /**
     * Applies the effect's function to the given health value
     * @return the result of the function
     */
    public int onTurn(int health) { return onTurn.apply(health, this); }

    /**
     * Returns a unique identifier for the effect based on its type, potency, and duration.
     * This can be used to differentiate between multiple instances of the same effect.
     */
    private int generateID() { return (potency/duration) - type.ordinal() * 100; }

    /**
     * Returns the unique ID for this effect instance.
     * This is used to identify the effect when checking for equality with other effects.
     */
    public int uniqueId() { return uniqueId; } // Getter for the unique ID
    public Effects getType() { return type; } // Getter for the effect type
}