# STS Card Mod

基于 [Alchyr/BasicMod](https://github.com/Alchyr/BasicMod) 的 Slay the Spire 卡牌 Mod 模板。

## 项目结构

```
sts-card-mod/
├── pom.xml                          # Maven 配置
├── src/main/java/stsmod/
│   ├── STSCardMod.java              # Mod 主类
│   ├── cards/
│   │   ├── BaseCard.java            # 卡牌基类（简化创建）
│   │   └── ExampleAttack.java       # 示例攻击卡
│   └── util/
│       ├── CardStats.java           # 卡牌属性配置
│       └── TextureLoader.java       # 图片加载工具
├── src/main/resources/
│   ├── ModTheSpire.json             # Mod 配置
│   └ stsmod/
│       ├── localization/            # 本地化文件
│       │   ├── eng/cards.json       # 英文
│       │   └ zhs/cards.json         # 简体中文
│       └ images/
│           ├── badge.png            # Mod 图标（需添加）
│           └ cards/
│               ├── attack/           # 攻击卡图片
│               ├── skill/            # 技能卡图片
│               └ power/              # 能力卡图片
```

## 使用步骤

### 1. 配置 Steam 路径

编辑 `pom.xml`，修改 Steam 安装路径：

```xml
<steam.windows>C:/Program Files (x86)/steam/steamapps</steam.windows>
```

### 2. 安装 ModTheSpire 和 BaseMod

在 Steam 中订阅以下 Mod（游戏会自动下载到 `workshop/content/646570/`）：
- ModTheSpire (ID: 1605060445)
- BaseMod (ID: 1605833019)
- StSLib (ID: 1609158507)

### 3. 构建

```bash
mvn package
```

### 4. 安装

将 `target/stsmod.jar` 复制到游戏 `mods/` 目录。

### 5. 运行

使用 ModTheSpire 启动游戏。

## 添加新卡牌

### 方法 1：继承 BaseCard（推荐）

```java
public class MyNewCard extends BaseCard {
    public static final String ID = makeID("MyNewCard");
    private static final CardStats info = new CardStats(
        CardColor.RED,      // 颜色
        CardType.ATTACK,    // 类型
        CardRarity.COMMON,  // 稀有度
        CardTarget.ENEMY,   // 目标
        2                   // 花费
    );

    public MyNewCard() {
        super(ID, info);
        setDamage(12, 4);  // 伤害 12，升级 +4
        setBlock(5);       // 格挡 5（可选）
        setMagic(2);       // 魔法数字 2（可选）
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage), AttackEffect.SLASH_HEAVY));
    }
}
```

### 方法 2：在主类注册

```java
@Override
public void receiveEditCards() {
    BaseMod.addCard(new MyNewCard());
}
```

### 方法 3：添加本地化

在 `localization/eng/cards.json` 添加：

```json
{
  "stsmod:MyNewCard": {
    "NAME": "My New Card",
    "DESCRIPTION": "Deal !D! damage. Gain !B! block."
  }
}
```

## 卡牌属性参考

### CardColor（颜色/角色）

| 颜色 | 角色 |
|------|------|
| RED | 铁甲战士 (Ironclad) |
| GREEN | 潦草猎人 (Silent) |
| BLUE | 静默机械师 (Defect) |
| PURPLE | 观者 (Watcher) |
| COLORLESS | 通用卡 |

### CardType（类型）

| 类型 | 说明 |
|------|------|
| ATTACK | 攻击卡 |
| SKILL | 技能卡 |
| POWER | 能力卡 |
| STATUS | 状态卡 |
| CURSE |诅咒卡 |

### CardRarity（稀有度）

| 稀有度 | 说明 |
|------|------|
| BASIC | 基础卡 |
| COMMON | 普通卡 |
| UNCOMMON | 罕见卡 |
| RARE |稀有卡 |
| SPECIAL | 特殊卡 |

### CardTarget（目标）

| 目标 | 说明 |
|------|------|
| ENEMY | 单个敌人 |
| ALL_ENEMY | 所有敌人 |
| SELF | 自己 |
| SELF_AND_ENEMY | 自己和敌人 |
| ALL | 所有 |
| NONE | 无目标 |

## 参考资源

- [Alchyr/BasicMod Wiki](https://github.com/Alchyr/BasicMod/wiki) - 详细教程
- [BaseMod Wiki](https://github.com/SkyeStarfall/BaseMod) - BaseMod 文档
- [STS Modding 中文教程](https://github.com/kidmusic/SlayTheSpireBaseModWiki-ZH)