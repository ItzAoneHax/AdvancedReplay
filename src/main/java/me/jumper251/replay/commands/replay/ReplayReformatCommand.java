package me.jumper251.replay.commands.replay;



import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.jumper251.replay.ReplaySystem;
import me.jumper251.replay.commands.AbstractCommand;
import me.jumper251.replay.commands.SubCommand;
import me.jumper251.replay.filesystem.saving.DefaultReplaySaver;
import me.jumper251.replay.filesystem.saving.ReplaySaver;

public class ReplayReformatCommand extends SubCommand {

	public ReplayReformatCommand(AbstractCommand parent) {
		super(parent, "reformat", "重新格式化回放", "reformat", false);
		
		this.setEnabled(false);
	}

	@Override
	public boolean execute(CommandSender cs, Command cmd, String label, String[] args) {
		cs.sendMessage(ReplaySystem.PREFIX + "正在重新格式化回放文件...");
		((DefaultReplaySaver)ReplaySaver.replaySaver).reformatAll();
		cs.sendMessage("§a完成。请检查控制台获取详情。");
		
		return true;
	}

	
}
