## BaseMod Hook 接口完整列表

---

## 🎴 卡牌相关

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `EditCardsSubscriber` | 游戏初始化时，注册卡牌 | 添加自定义卡牌 |
| `PostDrawSubscriber` | 抽牌后 | 监听抽牌事件 |
| `PostExhaustSubscriber` | 消耗卡牌后 | 监听消耗事件 |
| `OnCardUseSubscriber` | 卡牌使用后立即触发 | 卡牌效果增强 |
| `OnCreateDescriptionSubscriber` | 创建卡牌描述时 | 动态修改卡牌文本 |
| `AlternateCardCostModifier` | 计算卡牌费用时 | 修改卡牌费用（如遗物效果） |
| `XCostModifier` | X费用卡牌计算时 | 修改X费用卡牌效果 |

---

## 🎮 游戏流程

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `PostInitializeSubscriber` | 游戏初始化完成后（仅一次） | Mod 入口，注册 badge |
| `PreStartGameSubscriber` | 开始/继续游戏后，生成玩家前 | 游戏前设置 |
| `StartGameSubscriber` | 开始/继续游戏后，生成玩家后，地牢生成前 | 初始化玩家 |
| `StartActSubscriber` | 新章节开始 | 监听章节切换 |
| `PostDungeonInitializeSubscriber` | 地牢初始化完成后 | 地牢生成后操作 |
| `PostCampfireSubscriber` | 篝火事件后 | 修改篝火效果 |
| `PostBattleSubscriber` | 战斗结束后 | 战斗结算处理 |
| `PostDeathSubscriber` | 死亡后 | 死亡统计/处理 |
| `OnStartBattleSubscriber` | 战斗开始时 | 战斗初始化 |

---

## ⚡ 玩家相关

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `PrePlayerUpdateSubscriber` | 玩家 update 前 | 玩家行为拦截 |
| `PostPlayerUpdateSubscriber` | 玩家 update 后 | 玩家行为处理 |
| `OnPlayerTurnStartSubscriber` | 玩家回合开始时（抽牌前） | 回回合开始效果 |
| `OnPlayerTurnStartPostDrawSubscriber` | 玩家回合开始后（抽牌后） | 抽牌后效果 |
| `OnPlayerDamagedSubscriber` | 玩家受到伤害时 | 伤害处理 |
| `OnPlayerLoseBlockSubscriber` | 玩家失去格挡时 | 格挡处理 |
| `MaxHPChangeSubscriber` | 最大生命值改变时 | 修改生命值变化 |

---

## 🔮 能力

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `OnPowersModifiedSubscriber` | 能力被修改时 | 监听能力变化 |
| `PostPowerApplySubscriber` | 能力应用后 | 能力效果处理 |
| `CloneablePowerInterface` | 能力复制时 | 能力克隆接口 |

---

## 💊 药水

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `PrePotionUseSubscriber` | 药水使用前 | 药水效果拦截 |
| `PostPotionUseSubscriber` | 药水使用后 | 药水效果处理 |
| `PotionGetSubscriber` | 获得药水时 | 监听药水获取 |

---

## 🏺 遗物

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `EditRelicsSubscriber` | 游戏初始化时，注册遗物 | 添加自定义遗物 |
| `PostCreateStartingRelicsSubscriber` | 初始遗物创建后 | 修改初始遗物 |
| `RelicGetSubscriber` | 获得遗物时 | 监听遗物获取 |

---

## 🃏 起始套牌

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `PostCreateStartingDeckSubscriber` | 初始套牌创建后 | 修改起始套牌 |

---

## 🏪 商店

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `PostCreateShopRelicSubscriber` | 商店遗物生成后 | 修改商店遗物 |
| `PostCreateShopPotionSubscriber` | 商店药水生成后 | 修改商店药水 |

---

## 🎨 渲染

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `PreRenderSubscriber` | 渲染前 | 底层渲染 |
| `ModelRenderSubscriber` | 3D模型渲染时 | 结合 `receiveCameraRender` |
| `PreRoomRenderSubscriber` | 房间渲染前（玩家、敌人、背景后） | 中层渲染 |
| `RenderSubscriber` | 提示和光标后，其他之上 | UI渲染 |
| `PostRenderSubscriber` | 所有渲染之上 | 最高层渲染 |
| `ScreenPostProcessor` | 屏幕后处理 | 特效处理 |

---

## 🔄 更新循环

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `PreUpdateSubscriber` | 输入读取后立即触发 | 输入处理前 |
| `PostUpdateSubscriber` | 输入处理前立即触发 | 输入处理后 |
| `PreDungeonUpdateSubscriber` | 地牢 update 前 | 地牢逻辑拦截 |
| `PostDungeonUpdateSubscriber` | 地牢 update 后 | 地牢逻辑处理 |
| `PreMonsterTurnSubscriber` | 怪物回合开始前 | 怪物回合拦截 |

---

## ⚡ 能量

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `PostEnergyRechargeSubscriber` | 能量重置后（每回合开始） | 修改能量 |

---

## 🎭 自定义内容

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `EditCharactersSubscriber` | 游戏初始化时 | 添加自定义角色 |
| `EditKeywordsSubscriber` | 游戏初始化时 | 添加自定义关键词 |
| `EditStringsSubscriber` | 游戏初始化时 | 加载本地化文件 |
| `SetUnlocksSubscriber` | 游戏初始化时 | 设置解锁奖励 |
| `AddAudioSubscriber` | 游戏初始化时 | 添加自定义音频 |
| `AddCustomModeModsSubscriber` | 自定义模式时 | 添加自定义模式选项 |

---

## 🖥️ 其他

| Hook | 触发时机 | 用途 |
|------|---------|------|
| `ImGuiSubscriber` | ImGui 渲染时 | 调试界面 |
| `TextReceiver` | 文本输入时 | 控制台命令处理 |
| `DraggableUI` | UI 拖拽时 | 自定义 UI 元素 |

---

## 使用示例

```java
@SpireInitializer
public class MyMod implements 
        PostInitializeSubscriber,    // 游戏初始化
        EditCardsSubscriber,         // 注册卡牌
        EditStringsSubscriber,       // 加载本地化
        PostDrawSubscriber,          // 监听抽牌
        OnStartBattleSubscriber {    // 战斗开始

    public MyMod() {
        BaseMod.subscribe(this);  // 一次性订阅所有实现的接口
    }

    public static void initialize() {
        new MyMod();
    }

    @Override
    public void receivePostInitialize() {
        // 游戏初始化完成
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new MyCard());
    }

    @Override
    public void receiveEditStrings() {
        BaseMod.loadCustomStringsFile(CardStrings.class, "localization/cards.json");
    }

    @Override
    public void receivePostDraw(AbstractCard card) {
        // 每次抽牌都会触发
    }

    @Override
    public void receiveOnStartBattle() {
        // 战斗开始时触发
    }
}
```

---

**完整源码：** https://github.com/daviscook477/BaseMod/tree/master/mod/src/main/java/basemod/interfaces

**中文Wiki：** https://github.com/kidmusic/SlayTheSpireBaseModWiki-ZH/blob/master/Hooks.md 🌙