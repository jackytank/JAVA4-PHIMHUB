const footerTemplate = document.createElement('template');

footerTemplate.innerHTML = `
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
    integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<title>Phimkhongmoi</title>
<footer class="footer">
<div class="content has-text-centered">
    <p>
        <strong>Assignment Java 4</strong> by <a href="https://jgthms.com">Group 4</a>. The source code is
        licensed
        <a href="http://opensource.org/licenses/mit-license.php">MIT</a>. The website content
        is licensed <a href="http://creativecommons.org/licenses/by-nc-sa/4.0/">CC BY NC SA 4.0</a>.
    </p>
    <div class="block">
        <span class="icon">
            <i class="fab fa-lg fa-twitter"></i>
        </span>
        <span class="icon">
            <i class="fab fa-lg fa-youtube"></i>
        </span>
        <span class="icon">
            <i class="fab fa-lg fa-facebook"></i>
        </span>
        <span class="icon">
            <i class="fab fa-lg fa-github"></i>
        </span>
    </div>
</div>
</footer>
`;

class Footer extends HTMLElement {
	constructor() {
		super();
	}

	connectedCallback() {
		const shadowRoot = this.attachShadow({ mode: `closed` });

		shadowRoot.appendChild(footerTemplate.content);
	}
}

customElements.define("footer-component", Footer);
