import { form, delBtn } from '../DOM/reusable-DOMs.js';

function initializePage() {
  if (form) form.reset();

  const limitedTextArea = document.querySelector('limited-textarea');
  if (limitedTextArea) limitedTextArea.reset();

  const actived = document.querySelector('#menuManageAccordion .list-group-item.active');
  if (actived) actived.classList.remove('active');

  const expanded = document.querySelector('#menuManageAccordion button[aria-expanded="true"]');
  if (expanded) expanded.click();

  delBtn.style.display = 'none';
}

export { initializePage };
