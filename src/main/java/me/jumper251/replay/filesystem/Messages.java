package me.jumper251.replay.filesystem;

import me.jumper251.replay.ReplaySystem;
import me.jumper251.replay.utils.LogUtils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class Messages {

    public static final ConfigMessage PREFIX = new ConfigMessage("prefix", "&8[&3回放&8] &r&7", false);

    public static final ConfigMessage COMMAND_SYNTAX = new ConfigMessage("command.syntax", "用法: &6/{command} {args}");
    public static final ConfigMessage COMMAND_OVERVIEW = new ConfigMessage("command.overview", "&6/{command} {args} &7 - {desc}", false);
    public static final ConfigMessage COMMAND_NOTFOUND = new ConfigMessage("command.not_found", "&7命令未找到。");
    public static final ConfigMessage COMMAND_NO_PERMISSION = new ConfigMessage("command.no_permission", "&c权限不足");

    public static final ConfigMessage QUALITY_LOW = new ConfigMessage("general.quality_low", "&c低", false);
    public static final ConfigMessage QUALITY_MEDIUM = new ConfigMessage("general.quality_medium", "&e中", false);
    public static final ConfigMessage QUALITY_HIGH = new ConfigMessage("general.quality_high", "&a高", false);

    public static final ConfigMessage REPLAYING_WORLD_NOT_FOUND = new ConfigMessage("replaying.world_not_found", "&c该回放的世界不存在或未加载。({world})");
    public static final ConfigMessage REPLAYING_FINISHED_WATCHING = new ConfigMessage("replaying.finish_watching", "回放已结束。");
    public static final ConfigMessage REPLAYING_PLAYER_DEATH = new ConfigMessage("replaying.player_death", "&6{name} &7已死亡。");
    public static final ConfigMessage REPLAYING_PLAYER_LEAVE = new ConfigMessage("replaying.player_leave", "&6{name} &7已离开游戏。");
    public static final ConfigMessage REPLAYING_PLAYER_JOIN = new ConfigMessage("replaying.player_leave", "&6{name} &7已加入游戏。", false);

    public static final ConfigMessage REPLAY_NOT_FOUND = new ConfigMessage("replay.not_found", "&c回放未找到。");

    public static final ConfigMessage REPLAY_START = new ConfigMessage("replay.start", "&a成功开始录制 &e{replay}&7。\n&7使用 &6/Replay stop {replay}&7 来保存录制。");
    public static final ConfigMessage REPLAY_START_TIMED = new ConfigMessage("replay.start_timed", "&a成功开始录制 &e{replay}&7。\n&7回放将在 &6{duration}&7 秒后保存");
    public static final ConfigMessage REPLAY_START_INFO = new ConfigMessage("replay.start_info", "&7信息: 正在录制所有在线玩家。", false);
    public static final ConfigMessage REPLAY_START_EXISTS = new ConfigMessage("replay.start_exists", "&c回放已存在。");
    public static final ConfigMessage REPLAY_START_TOO_LONG = new ConfigMessage("replay.start_too_long", "&c回放名称过长。");
    public static final ConfigMessage REPLAY_START_INVALID_NAME = new ConfigMessage("replay.start_name_invalid", "&c回放名称包含非法字符。");

    public static final ConfigMessage REPLAY_DELETE = new ConfigMessage("replay.delete", "&a成功删除回放。");

    public static final ConfigMessage REPLAY_LEAVE = new ConfigMessage("replay.leave", "&c你需要先播放一个回放");

    public static final ConfigMessage REPLAY_PLAY = new ConfigMessage("replay.play", "回放已加载。时长 &e{duration}&7 秒。");
    public static final ConfigMessage REPLAY_PLAY_LOAD = new ConfigMessage("replay.play_load", "正在加载回放 &e{replay}&7...");
    public static final ConfigMessage REPLAY_PLAY_ERROR = new ConfigMessage("replay.play_error", "&c加载 &o{replay}.replay &c时出错。请查看控制台获取更多信息。");

    public static final ConfigMessage REPLAY_STOP_SAVING = new ConfigMessage("replay.stop_saving", "正在保存回放 &e{replay}&7...");
    public static final ConfigMessage REPLAY_STOP_NO_SAVE = new ConfigMessage("replay.stop_no_save", "&7成功停止回放 &e{replay}");
    public static final ConfigMessage REPLAY_STOP_SAVED = new ConfigMessage("replay.stop_saved", "&7成功保存回放");
    public static final ConfigMessage REPLAY_STOP_SAVED_TO = new ConfigMessage("replay.stop_saved_to", "&7成功保存回放到 &o{path}");
    public static final ConfigMessage REPLAY_STOP_EXISTS = new ConfigMessage("replay.stop_exists", "&c回放已存在。使用 &o-force &r&c来覆盖或 &o-nosave &r&c来丢弃录制。");

    public static final ConfigMessage REPLAY_JUMP = new ConfigMessage("replay.jump", "正在跳转到 &e{time} &7秒...");
    public static final ConfigMessage REPLAY_JUMP_INVALID = new ConfigMessage("replay.jump_invalid", "&c时间必须在 1 到 {duration} 之间");
    public static final ConfigMessage REPLAY_JUMP_NOT_IN_REPLAY = new ConfigMessage("replay.jump_not_in_replay", "&c你需要先播放一个回放");

    public static final ConfigMessage REPLAY_INFO_LOADING = new ConfigMessage("replay.info_loading", "正在加载回放 &e{replay}&7...");
    public static final ConfigMessage REPLAY_INFO_HEADER = new ConfigMessage("replay.info.header", "&c» &7关于 &e&l{replay} &c的信息 &c«", false);
    public static final ConfigMessage REPLAY_INFO_SPACE = new ConfigMessage("replay.info.space", " ", false);
    public static final ConfigMessage REPLAY_INFO_CREATOR = new ConfigMessage("replay.info.creator", "&7&o创建者: &9{creator}", false);
    public static final ConfigMessage REPLAY_INFO_DURATION = new ConfigMessage("replay.info.duration", "&7&o时长: &6{duration} &7&o秒", false);
    public static final ConfigMessage REPLAY_INFO_PLAYERS = new ConfigMessage("replay.info.players", "&7&o玩家: &6{players}", false);
    public static final ConfigMessage REPLAY_INFO_QUALITY = new ConfigMessage("replay.info.quality", "&7&o质量: {quality}", false);
    public static final ConfigMessage REPLAY_INFO_ENTITIES = new ConfigMessage("replay.info.entities", "&7&o实体: &6{entities}", false);
    public static final ConfigMessage REPLAY_INFO_HOVER_PART1 = new ConfigMessage("replay.info_hover.part1", "&7&o录制的数据: ", false);
    public static final ConfigMessage REPLAY_INFO_HOVER_PART2 = new ConfigMessage("replay.info_hover.part2", "&6&n{action_count}&r", false);
    public static final ConfigMessage REPLAY_INFO_HOVER_PART3 = new ConfigMessage("replay.info_hover.part3", "&7{data}: &b{amount}", false);
    public static final ConfigMessage REPLAY_INFO_HOVER_PART4 = new ConfigMessage("replay.info_hover.part4", " &7&o条动作", false);

    public static final ConfigMessage REPLAY_LIST_HEADER = new ConfigMessage("replay.list_header", "可用回放: &8(&6{replays}&8) &7| 页面: &e{page}&7/&e{pages}");
    public static final ConfigMessage REPLAY_LIST_ENTRY = new ConfigMessage("replay.list_entry", " &6&o{date}    &e{replay}", false);
    public static final ConfigMessage REPLAY_LIST_NO_REPLAYS = new ConfigMessage("replay.list_no_replays", "&c未找到回放。");
    public static final ConfigMessage REPLAY_LIST_HOVER_HEADER = new ConfigMessage("replay.list_hover.header", "&7回放 &e&l{replay}", false);
    public static final ConfigMessage REPLAY_LIST_HOVER_SPACE = new ConfigMessage("replay.list_hover.space", " ", false);
    public static final ConfigMessage REPLAY_LIST_HOVER_CREATOR = new ConfigMessage("replay.list_hover.creator", "&7创建者: &6{creator}", false);
    public static final ConfigMessage REPLAY_LIST_HOVER_DURATION = new ConfigMessage("replay.list_hover.duration", "&7时长: &6{duration} &8秒", false);
    public static final ConfigMessage REPLAY_LIST_HOVER_SPACE2 = new ConfigMessage("replay.list_hover.space", " ", false);
    public static final ConfigMessage REPLAY_LIST_HOVER_ACTION = new ConfigMessage("replay.list_hover.action", "&7点击播放！", false);

    public static final ConfigMessage REPLAY_MIGRATE = new ConfigMessage("replay.migrate", "&7正在迁移回放到 &e{option}");
    public static final ConfigMessage REPLAY_MIGRATE_ERROR = new ConfigMessage("replay.migrate_error", "&c无法迁移到同一系统。");
    public static final ConfigMessage REPLAY_MIGRATE_INVALID = new ConfigMessage("replay.migrate_invalid", "&c无效的参数。{options}");

    public static final ConfigMessage REPLAY_RELOAD = new ConfigMessage("replay.reload", "&a成功重新加载配置。");

    public static final ConfigMessage GUI_TELEPORTER_NEXT_PAGE = new ConfigMessage("gui.teleporter.next_page", "&a下一页", false);
    public static final ConfigMessage GUI_TELEPORTER_PREVIOUS_PAGE = new ConfigMessage("gui.teleporter.previous_page", "&a上一页", false);


    private static final Map<String, ConfigMessage> MESSAGES = new LinkedHashMap<>();

    private static final File LANG_FILE = new File(ReplaySystem.getInstance().getDataFolder(), "lang.yml");
    private static FileConfiguration cfg;

    static {
        try {
            for (Field field : Messages.class.getFields()) {
                if (!field.getType().isAssignableFrom(ConfigMessage.class)) continue;
                ConfigMessage message = (ConfigMessage) field.get(null);

                MESSAGES.put(message.getKey(), message);
            }

        } catch (Exception e) {
            LogUtils.log("Error while loading messages: " + e.getMessage());
        }
    }


    public static MessageBuilder combined(ConfigMessage... messages) {
        return new MessageBuilder(messages);
    }

    public static void loadMessages() {
        if (cfg == null) {
            cfg = YamlConfiguration.loadConfiguration(LANG_FILE);
        } else {
            try {
                cfg.load(LANG_FILE);
            } catch (IOException | InvalidConfigurationException e) {
                LogUtils.log("Error while loading messages: " + e.getMessage());
            }
        }

        boolean update = false;

        for (Map.Entry<String, ConfigMessage> entry : MESSAGES.entrySet()) {
            if (cfg.contains(entry.getKey())) {
                entry.getValue().setMessage(cfg.getString(entry.getKey()));
            } else {
                cfg.set(entry.getKey(), entry.getValue().getDefaultMessage());
                entry.getValue().setMessage(entry.getValue().getDefaultMessage());
                update = true;
            }
        }

        if (update) {
            try {
                cfg.save(LANG_FILE);
            } catch (Exception e) {
                LogUtils.log("Error while saving messages: " + e.getMessage());
            }
        }
    }
}
