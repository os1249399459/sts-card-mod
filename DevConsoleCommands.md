## BaseMod Dev Console 完整命令列表

---

## 开启控制台

按 **`~`**（波浪号）键开启，可在 BaseMod 设置中更改快捷键。

---

## 🃏 套牌修改

| 命令 | 说明 |
|------|------|
| `deck add [id] {数量} {升级次数}` | 向套牌添加卡牌 |
| `deck remove [id]` | 从套牌移除卡牌 |
| `deck remove all` | 移除所有卡牌 |

**示例：**
```
deck add stsmod:ExampleAttack 3 1
→ 添加 3 张升级版的 ExampleAttack
```

---

## ⚔️ 战斗中

| 命令 | 说明 |
|------|------|
| `draw [数量]` | 抽卡 |
| `energy add [数量]` | 获得能量 |
| `energy inf` | 无限能量 |
| `energy remove [数量]` | 失去能量 |
| `hand add [id] {数量} {升级次数}` | 向手牌添加卡牌 |
| `hand remove all` | 移除所有手牌 |
| `hand remove [id]` | 从手牌移除卡牌 |
| `kill all` | 杀死所有敌人 |
| `kill self` | 自杀 |
| `power [id] [数量]` | 获得/给敌人能力 |

---

## 🚪 战斗外

| 命令 | 说明 |
|------|------|
| `fight [名字]` | 进入指定战斗 |
| `event [名字]` | 进入指定事件 |

---

## 💰 任何时间

| 命令 | 说明 |
|------|------|
| `gold add [数量]` | 获得金币 |
| `gold lose [数量]` | 失去金币 |
| `hp add [数量]` | 获得生命 |
| `hp remove [数量]` | 失去生命 |
| `maxhp add [数量]` | 获得生命上限 |
| `maxhp remove [数量]` | 失去生命上限 |
| `potion [位置] [id]` | 获得药水（位置 0/1/2） |
| `info toggle` | 切换信息显示 |
| `debug [true/false]` | 设置调试模式 |

---

## 🏺 遗物

| 命令 | 说明 |
|------|------|
| `relic add [id]` | 添加遗物 |
| `relic list` | 显示所有遗物列表 |
| `relic remove [id]` | 移除遗物 |

---

## 🔓 解锁

| 命令 | 说明 |
|------|------|
| `unlock always` | 总是在死亡时获得解锁 |
| `unlock level [等级]` | 设置解锁等级 |

---

## 🗺️ 地图/章节

| 命令 | 说明 |
|------|------|
| `act boss` | 直达 Boss |
| `act [章节名]` | 回到起始点 |

---

## 🔑 第四层钥匙

| 命令 | 说明 |
|------|------|
| `key add [颜色/all]` | 添加钥匙（ruby/emerald/sapphire/all） |
| `key lose [颜色/all]` | 移除钥匙 |

---

## 📜 历史

| 命令 | 说明 |
|------|------|
| `history random` | 随机获得通关牌组+遗物 |
| `history last` | 获得最后一次通关牌组+遗物 |

---

## 💊 药水位置

| 命令 | 说明 |
|------|------|
| `potion 0 AttackPotion` | 药水槽位 0 |
| `potion 1 FirePotion` | 药水槽位 1 |
| `potion 2 BlockPotion` | 药水槽位 2 |

---

## 常用示例

```
# 快速测试自定义卡牌
hand add stsmod:ExampleAttack

# 无限能量测试
energy inf

# 添加遗物
relic add BurningBlood

# 加金币
gold 1000

# 直接打 Boss
act boss

# 杀死所有敌人（测试用）
kill all

# 查看所有遗物 ID
relic list
```

---

**现在你可以用 `hand add stsmod:ExampleAttack` 来测试你的卡牌了！** 🌙