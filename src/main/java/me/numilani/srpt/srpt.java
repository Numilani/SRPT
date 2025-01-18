package me.numilani.srpt;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.incendo.cloud.annotations.AnnotationParser;
import org.incendo.cloud.execution.ExecutionCoordinator;
import org.incendo.cloud.paper.LegacyPaperCommandManager;
import org.incendo.cloud.parser.ParserParameters;

import com.bergerkiller.bukkit.common.config.FileConfiguration;

public final class srpt extends JavaPlugin {

  public LegacyPaperCommandManager<CommandSender> cmdHandler;
  public AnnotationParser<CommandSender> cmdParser;
  public FileConfiguration cfg;

  @Override
  public void onEnable() {
    try {
      cmdHandler = LegacyPaperCommandManager.createNative(this, ExecutionCoordinator.simpleCoordinator());
      cmdParser = new AnnotationParser<>(cmdHandler, CommandSender.class,
          ParserParameters -> SimpleCommandMeta.empty());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    if (!(new FileConfiguration(this, "config.yml").exists())) {
      doFirstRunInit();
    }

  }

  @Override
  public void onDisable() {
  }

  private void doFirstRunInit() {

  }
}
