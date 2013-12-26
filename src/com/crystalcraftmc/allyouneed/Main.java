package com.crystalcraftmc.allyouneed;

import org.bukkit.plugin.java.JavaPlugin;

import com.crystalcraftmc.allyouneed.Commands.AYNCt;
import com.crystalcraftmc.allyouneed.Commands.AYNDefineSpawn;
import com.crystalcraftmc.allyouneed.Commands.AYNEnder;
import com.crystalcraftmc.allyouneed.Commands.AYNFly;
import com.crystalcraftmc.allyouneed.Commands.AYNHeal;
import com.crystalcraftmc.allyouneed.Commands.AYNHome;
import com.crystalcraftmc.allyouneed.Commands.AYNKickall;
import com.crystalcraftmc.allyouneed.Commands.AYNMypos;
import com.crystalcraftmc.allyouneed.Commands.AYNRules;
import com.crystalcraftmc.allyouneed.Commands.AYNSetHome;
import com.crystalcraftmc.allyouneed.Commands.AYNSpawn;
import com.crystalcraftmc.allyouneed.Commands.AYNTpgo;
import com.crystalcraftmc.allyouneed.Commands.AYNTphere;
import com.crystalcraftmc.allyouneed.Commands.AYNTppos;
import com.crystalcraftmc.allyouneed.Listeners.BanBlocks;

public final class Main extends JavaPlugin {
	@Override
	public void onEnable() {

		// TestZone - temporary

		// TestZone/

		getLogger().info("All You Need has been enabled!");

		// BanBlocks
		new BanBlocks(this);
		// BanBlocks/

		// HomeList
		HomeListConfig HLC = new HomeListConfig(this);
		AYNSetHome.HomeListConfig = HLC;
		AYNHome.HomeListConfig = HLC;
		// HomeList/


		// Config
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		// Config/

	

		// Commands
		getCommand("ct").setExecutor(new AYNCt(this));
		getCommand("ender").setExecutor(new AYNEnder(this));
		getCommand("tp").setExecutor(new AYNTpgo(this));
		getCommand("tphere").setExecutor(new AYNTphere(this));
		getCommand("tppos").setExecutor(new AYNTppos(this));
		getCommand("setspawn").setExecutor(new AYNDefineSpawn(this));
		getCommand("spawn").setExecutor(new AYNSpawn(this));
		getCommand("sethome").setExecutor(new AYNSetHome(this));
		getCommand("home").setExecutor(new AYNHome(this));
		getCommand("heal").setExecutor(new AYNHeal(this));
		getCommand("rules").setExecutor(new AYNRules(this));
		getCommand("kickall").setExecutor(new AYNKickall(this));
		getCommand("fly").setExecutor(new AYNFly(this));
		getCommand("mypos").setExecutor(new AYNMypos(this));
		
		// Commands/

	}

	@Override
	public void onDisable() {
		getLogger().info("All You Need has been disabled!");
		// this.saveConfig();
		// this holds the config in cache, which disallows ppl to change config
		// args and
		// reload the server.
	}
}
/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */