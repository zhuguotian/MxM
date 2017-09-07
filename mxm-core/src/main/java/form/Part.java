package form;

import base.Instrument;
import base.Chord;
import base.ISound;
import base.Noise;
import base.Pitch;
import base.Tempo;
import base.time.Time;
import base.TimeSig;
import org.jetbrains.annotations.NotNull;
import form.events.Note;
import form.events.TempoChange;
import form.events.TimeSigChange;

import java.util.Iterator;

public abstract class Part<SoundType extends ISound> implements IPassage {
    private final Score score;
    private final Instrument instrument;

    Part(Score score, Instrument instrument) {
        this.score = score;
        this.instrument = instrument;
    }

    public final @NotNull Score getScore() { return score; }
    public final @NotNull Instrument getInstrument() { return instrument; }

    // Iterators over specific event types
    @Override
    public final @NotNull SerialTimeline<TimeSigChange> getTimeSigChanges() { return getScore().getTimeSigChanges(); }
    @Override
    public final @NotNull SerialTimeline<TempoChange> getTempoChanges() { return getScore().getTempoChanges(); }

    // Getters for form.events during a specific time
    @Override
    public final @NotNull Tempo getTempoAt(Time time) { return getScore().getTempoAt(time); }
    @Override
    public final @NotNull TimeSig getTimeSigAt(Time time) { return getScore().getTimeSigAt(time); }




    @Override
    public Iterator<Note> noteItrAt(Time time) { return null; }
    @Override
    public Iterator<Note<Pitch>> pitchedNoteItrAt(Time time) { return null; }
    @Override
    public Iterator<Note<Noise>> unpitchedNoteItrAt(Time time) { return null; }
    @Override
    public Iterator<Note<Chord>> chordNoteItrAt(Time time) { return null; }
}
