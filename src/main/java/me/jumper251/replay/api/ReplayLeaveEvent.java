package me.jumper251.replay.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.jumper251.replay.replaysystem.Replay;

public class ReplayLeaveEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Replay replay;
    private final Player player;

    public ReplayLeaveEvent(Replay replay, Player player) {
        super(!Bukkit.isPrimaryThread());
        this.replay = replay;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public Replay getReplay() {
        return replay;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

