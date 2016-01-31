package br.com.srmourasilva.modhostbinding;

import br.com.srmourasilva.test.Lv2Effect;

/**
 * Prepare the objects to <a href="https://github.com/moddevices/mod-host">mod-parse</a>
 * string command
 */
public class ProtocolParser {

	/**
	 * add <lv2_uri> <instance_number>
	 * 
	 * add a LV2 plugin encapsulated as a jack client
	 * e.g.: add http://lv2plug.in/plugins/eg-amp 0
	 * instance_number must be any value between 0 ~ 9999, inclusively
	 */
	public static String add(Lv2Effect effect) {
		return "add " + effect.getLv2Uri() + " " + effect.getInstanceNumber();
	}

	/**
	 * remove <instance_number>
	 * 
	 * remove a LV2 plugin instance (and also the jack client)
	 * e.g.: remove 0
	 */
	public static String remove(Lv2Effect effect) {
		return "remove " + effect.getInstanceNumber();
	}

	/**
	 * Connect 'effect' in 'anotherEffect'
	 * 
	 * connect <origin_port> <destination_port>
	 * 
	 * connect two effect audio ports
	 * e.g.: connect system:capture_1 effect_0:in
	 */
	public static String connect(Lv2Effect effect, Lv2Effect anotherEffect) {
		return "connect " + effect.getOutName() + " " + anotherEffect.getInName();
	}

	/**
	 * disconnect <origin_port> <destination_port>
	 * 
	 * disconnect two effect audio ports
	 * e.g.: disconnect system:capture_1 effect_0:in
    */
	public static String disconnect(Lv2Effect effect, Lv2Effect anotherEffect) {
		return "disconnect " + effect.getOutName() + " " + anotherEffect.getInName();
	}

	/**
	 * preset_load <instance_number> <preset_uri>
	 * 
	 * load a preset state to given effect instance
	 * e.g.: preset_load 0 "http://drobilla.net/plugins/mda/presets#JX10-moogcury-lite"
	 */
	public static String presetLoad() {
		return null;
	}

    /**
     * preset_save <instance_number> <preset_name> <dir> <file_name>
     * 
     * save a preset state from given effect instance
     * e.g.: preset_save 0 "My Preset" /home/user/.lv2/my-presets.lv2 mypreset.ttl
     */
    public static String presetSave() {
		return null;
	}

    /**
     * preset_show <instance_number> <preset_uri>
     * 
     * show the preset information of requested instance / URI
     * e.g.: preset_show 0 http://drobilla.net/plugins/mda/presets#EPiano-bright
     */
    public static String presetShow() {
		return null;
	}

    /**
     * param_set <instance_number> <param_symbol> <param_value>
     * 
     * set a value to given control
     * e.g.: param_set 0 gain 2.50
     */
	public static String paramSet() {
		return null;
	}

    /**
     * param_get <instance_number> <param_symbol>
     * 
     * get the value of the request control
     * e.g.: param_get 0 gain
     */
    public static String paramGet() {
		return null;
	}

    
    /**
     * param_monitor <instance_number> <param_symbol> <cond_op> <value>
     * 
     * do monitoring a effect instance control port according given condition
     * e.g: param_monitor 0 gain > 2.50
     */
    public static String paramMonitor() {
		return null;
	}

    /**
     * monitor <addr> <port> <status>
     * 
     * open a socket port to monitoring parameters
     * e.g: monitor localhost 12345 1
     * if status = 1 start monitoring
     * if status = 0 stop monitoring
     */
    public static String monitor() {
		return null;
	}

    
    public enum EffectStatus {
    	BYPASS(1),
    	PROCESS(0);
    	
    	private int status;

		private EffectStatus(int status) {
			this.status = status;
		}
    	
    	public int getStatus() {
    		return status;
    	}
    }

    /**
     * bypass <instance_number> <bypass_value>
     * 
     * toggle effect processing
     * e.g.: bypass 0 1
     * if bypass_value = 1 bypass effect
     * if bypass_value = 0 process effect
     */
	public static String bypass(Lv2Effect effect, EffectStatus status) {
		return "bypass " + status.getStatus();
	}


    /**
     * load <file_name>
     * 
     * load a history command file
     * dummy way to save/load workspace state
     * e.g.: load my_setup
     */
	public static String load() {
		return null;
	}


	/**
	 * save <file_name>
	 * 
	 * saves the history of typed commands
	 * dummy way to save/load workspace state
	 * e.g.: save my_setup 
	 */
	public static String save(String filename) {
		return "save " + filename;
	}

    /**
     * help
     * 
     * show a help message
     */
    public static String help() {
		return "help";
	}

    /**
     * quit
     * 
     * bye!
     */
    public static String quit() {
		return "quit";
	}
}
