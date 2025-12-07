function save() {
  const args = exptConfigs.map((config) => ({
    Key: config.key,
    Val: document.getElementById(config.key).checked
      ? config.trueVal
      : config.falseVal,
  }));
  console.log("保存配置:", args);
  if (window.WExpt && WExpt.putExptArgs) {
    try {
      WExpt.putExptArgs(JSON.stringify(args));
      alert("保存成功");
    } catch (error) {
      alert("保存出错: 调用失败");
    }
  } else {
    alert("保存出错: 接口异常");
  }
}

function initExptPage() {
  const container = document.getElementById("expt-container");
  exptConfigs.forEach((config) => {
    const label = document.createElement("label");
    label.className = "weui-cell weui-cell_active weui-check__label";
    label.setAttribute("for", config.key);
    label.innerHTML = `
            <div class="weui-cell__hd">
                <input type="checkbox" class="weui-check" id="${config.key}" />
                <i class="weui-icon-checked"></i>
            </div>
            <div class="weui-cell__bd">
                <p>${config.name}</p>
            </div>
        `;
    container.appendChild(label);
  });
  const saveBtn = document.getElementById("save");
  if (saveBtn) {
    saveBtn.addEventListener("click", save);
  }
}

document.addEventListener("DOMContentLoaded", initExptPage);
